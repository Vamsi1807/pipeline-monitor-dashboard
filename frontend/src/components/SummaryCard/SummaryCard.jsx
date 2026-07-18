import { useEffect, useState } from "react";
import api from "../../services/api";
import styles from "./SummaryCard.module.css";

export default function SummaryCard() {

    const [summary, setSummary] = useState(null);

    const loadSummary = async () => {

        try {

            const response = await api.get("/dashboard/summary");

            setSummary(response.data);

        } catch (error) {

            console.error(error);

        }

    };

    useEffect(() => {

        loadSummary();

    }, []);

    if (!summary) {

        return (

            <div className={styles.card}>

                Loading...

            </div>

        );

    }

    return (

        <div className={styles.card}>

            <div className={styles.header}>

                📊 Pipeline Summary

            </div>

            <div className={styles.row}>

                <span>Total Builds</span>

                <span>{summary.totalBuilds}</span>

            </div>

            <div className={styles.row}>

                <span>Successful</span>

                <span className={styles.success}>

                    {summary.successfulBuilds}

                </span>

            </div>

            <div className={styles.row}>

                <span>Failed</span>

                <span className={styles.failure}>

                    {summary.failedBuilds}

                </span>

            </div>

            <div className={styles.row}>

                <span>Success Rate</span>

                <span className={styles.success}>

                    {summary.successRate.toFixed(2)}%

                </span>

            </div>

            <div className={styles.row}>

                <span>Failure Rate</span>

                <span className={styles.failure}>

                    {summary.failureRate.toFixed(2)}%

                </span>

            </div>

        </div>

    );

}