import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import api from "../../services/api";
import styles from "./LatestBuild.module.css";

export default function LatestBuild() {

    const [build, setBuild] = useState(null);

    useEffect(() => {

        loadLatestBuild();

    }, []);

    async function loadLatestBuild() {

        try {

            const response = await api.get("/dashboard/latest");

            setBuild(response.data);

        } catch (error) {

            console.error(error);

        }

    }

    if (!build) {

        return (

            <div className={styles.card}>

                Loading...

            </div>

        );

    }

    return (

        <div className={styles.card}>

            <h3>🚀 Latest Build</h3>

            <div className={styles.divider}></div>

            <h2>{build.jobName}</h2>

            <span
                className={
                    build.status === "SUCCESS"
                        ? styles.success
                        : styles.failure
                }
            >
                {build.status}
            </span>

            <p>

                Build #{build.buildNumber}

            </p>

            <p>

                {build.branch}

            </p>

            <p>

                {new Date(build.buildTime).toLocaleString()}

            </p>

            <Link
                to={`/build/${build.id}`}
                className={styles.button}
            >
                View Details
            </Link>

        </div>

    );

}