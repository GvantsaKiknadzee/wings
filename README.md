# README

## Task Overview

This task involves performing calculations based on financial transfers from a client's card. The goal is to:

1. Calculate the average transfer amount over the last 6 months, rounding the result to the nearest whole number.
2. Determine the maximum transfer amount in a single month and identify the corresponding month.

## Conditions

1. Transfers with an amount less than $300 are excluded from the calculations.
2. Transfers within the same month are considered as a single transfer.

## Input Parameters

The calculations are based on two arrays:

- `transfers`: An array of double values representing the transfer amounts.
- `transfers_date`: An array of `LocalDate` objects representing the dates of each transfer.

