import streamlit as st
import pandas as pd
import csv
import os
import matplotlib.pyplot as plt
from datetime import datetime

st.set_page_config(page_title="Smart Expense Tracker", layout="wide")

st.title("Smart Expense Tracker")

EXPENSE_FILE = "expenses.csv"
BUDGET_FILE = "budget.txt"


def load_data():
    if os.path.exists(EXPENSE_FILE):
        df = pd.read_csv(EXPENSE_FILE)
        df["date"] = pd.to_datetime(df["date"], errors="coerce")
        return df
    return pd.DataFrame(columns=["date", "category", "amount", "description"])


def save_expense(row):
    file_exists = os.path.exists(EXPENSE_FILE)

    with open(EXPENSE_FILE, "a", newline="") as file:
        writer = csv.writer(file)
        if not file_exists:
            writer.writerow(["date", "category", "amount", "description"])
        writer.writerow(row)


def load_budget():
    if os.path.exists(BUDGET_FILE):
        with open(BUDGET_FILE, "r") as f:
            return float(f.read())
    return 0.0


def save_budget(value):
    with open(BUDGET_FILE, "w") as f:
        f.write(str(value))


df = load_data()
budget = load_budget()

menu = st.sidebar.radio("Menu", [
    "Dashboard",
    "Add Expense",
    "View Expenses",
    "Analysis"
])



if menu == "Dashboard":
    st.header("Dashboard")

    current_month = datetime.now().strftime("%Y-%m")

   
    if not df.empty:
        available_months = sorted(df["date"].dt.strftime("%Y-%m").dropna().unique())
    else:
        available_months = [current_month]

    selected_month = st.selectbox("Select Month", available_months, index=len(available_months)-1)

    
    monthly_total = 0
    if not df.empty:
        monthly_total = df[df["date"].dt.strftime("%Y-%m") == selected_month]["amount"].sum()

    budget_input = st.number_input("Set Monthly Budget", value=budget, min_value=0.0)

    if st.button("Save Budget"):
        save_budget(budget_input)
        st.success("Budget Saved")

    col1, col2, col3 = st.columns(3)

    remaining = max(budget_input - monthly_total, 0)

    with col1:
        st.metric(f"Total Spending ({selected_month})", f"₹{monthly_total:.2f}")

    with col2:
        st.metric("Budget", f"₹{budget_input:.2f}")

    with col3:
        st.metric("Remaining", f"₹{remaining:.2f}")

  
    if budget_input > 0:
        progress = min(monthly_total / budget_input, 1.0)
        st.progress(progress)

        if monthly_total > budget_input:
            st.error("Budget exceeded")
        elif monthly_total > budget_input * 0.8:
            st.warning("You are close to your budget limit")
        else:
            st.success("You are within your budget")

    st.markdown("---")

 
    col4, col5 = st.columns(2)

    with col4:
        st.subheader("Top Category")
        if not df.empty:
            cat_data = df.groupby("category")["amount"].sum()
            top_cat = cat_data.idxmax()
            st.info(f"{top_cat} is your highest spending category")

    with col5:
        st.subheader("Spending Summary")
        if not df.empty:
            avg_spend = df["amount"].mean()
            total_spend = df["amount"].sum()

            st.write(f"Average Expense: ₹{avg_spend:.2f}")
            st.write(f"Total Expenses: ₹{total_spend:.2f}")

    st.markdown("---")

   
    st.subheader("Recent Transactions")

    if not df.empty:
        recent = df.sort_values(by="date", ascending=False).head(5)
        st.dataframe(recent, use_container_width=True)
    else:
        st.warning("No recent transactions")



elif menu == "Add Expense":
    st.header("Add Expense")

    col1, col2 = st.columns(2)

    with col1:
        date = st.date_input("Date")
        category = st.selectbox("Category", ["Food", "Travel", "Bills", "Shopping", "Other"])

    with col2:
        amount = st.number_input("Amount", min_value=0.0)
        description = st.text_input("Description")

    if st.button("Add Expense"):
        if amount <= 0:
            st.warning("Enter valid amount")
        else:
            save_expense([date, category, amount, description])
            st.success("Expense Added Successfully")



elif menu == "View Expenses":
    st.header("All Expenses")

    if df.empty:
        st.warning("No data available")
    else:
        st.dataframe(df, use_container_width=True)

        st.subheader("Delete Expense")
        index = st.number_input("Enter row index to delete", min_value=0, step=1)

        if st.button("Delete"):
            if index < len(df):
                df = df.drop(index)
                df.to_csv(EXPENSE_FILE, index=False)
                st.success("Deleted successfully")
            else:
                st.error("Invalid index")


elif menu == "Analysis":
    st.header("Analysis & Insights")

    if df.empty:
        st.warning("No data available")
    else:
        st.subheader("Category Summary")
        cat = df.groupby("category")["amount"].sum()
        st.write(cat)

        st.subheader("Daily Spending")
        daily = df.groupby(df["date"].dt.date)["amount"].sum()
        st.write(daily)

        st.subheader("Category Distribution")

        fig, ax = plt.subplots()
        ax.pie(cat.values, labels=cat.index, autopct='%1.1f%%')
        ax.set_title("Expense Distribution")
        st.pyplot(fig)

        st.subheader("Monthly Spending Trend")

        df["month"] = df["date"].dt.to_period("M")
        monthly = df.groupby("month")["amount"].sum()

        fig2, ax2 = plt.subplots()
        ax2.plot(monthly.index.astype(str), monthly.values, marker='o')
        ax2.set_xlabel("Month")
        ax2.set_ylabel("Amount")
        ax2.set_title("Monthly Spending")
        st.pyplot(fig2)

        st.subheader("Key Insights")

        total = df["amount"].sum()
        top_category = cat.idxmax()

        st.write(f"Total Spending: ₹{total:.2f}")
        st.write(f"Top Category: {top_category}")