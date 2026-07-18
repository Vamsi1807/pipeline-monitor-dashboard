import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import api from "../../services/api";
import styles from "./RecentFailures.module.css";

export default function RecentFailures() {

    const [failures, setFailures] = useState([]);

    useEffect(() => {
        loadFailures();
    }, []);

    async function loadFailures() {

        try {

            const response = await api.get("/dashboard/failures");

            setFailures(response.data);

        } catch (error) {

            console.error(error);

        }

    }

    return (

        <div className={styles.card}>

            <h3>❌ Recent Failures</h3>

            <div className={styles.divider}></div>

            {failures.length === 0 ? (

                <p className={styles.noFailures}>
                    🎉 No recent failures
                </p>

            ) : (

                failures.map((build) => (

                    <div
                        key={build.id}
                        className={styles.failureCard}
                    >

                        <div>

                            <strong>{build.jobName}</strong>

                            <p>Build #{build.buildNumber}</p>

                            <small>

                                {new Date(build.buildTime).toLocaleString()}

                            </small>

                        </div>

                        <Link
                            to={`/build/${build.id}`}
                            className={styles.button}
                        >
                            View
                        </Link>

                    </div>

                ))

            )}

        </div>

    );

}