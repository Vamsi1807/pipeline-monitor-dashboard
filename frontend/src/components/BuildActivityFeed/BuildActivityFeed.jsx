import { useEffect, useState } from "react";
import api from "../../services/api";
import styles from "./BuildActivityFeed.module.css";

export default function BuildActivityFeed() {

    const [builds, setBuilds] = useState([]);

    async function loadBuilds() {

        try {

            const response = await api.get("/dashboard/recent");

            setBuilds(response.data);

        } catch (error) {

            console.error(error);

        }

    }

    useEffect(() => {

        loadBuilds();

    }, []);

    return (

        <div className={styles.container}>

            <div className={styles.header}>

                <h2>Recent Build Activity</h2>

                <button onClick={loadBuilds}>

                    🔄 Refresh

                </button>

            </div>

            <div className={styles.tableHeader}>

                <span>Status</span>

                <span>Project</span>

                <span>Build</span>

                <span>Branch</span>

                <span>Commit</span>

                <span>Time</span>

                <span>Duration</span>

            </div>

            {builds.map((build) => (

                <div
                    key={build.id}
                    className={styles.row}
                >

                    <span>

                        {build.status === "SUCCESS"
                            ? "🟢"
                            : "🔴"}

                    </span>

                    <span>

                        {build.jobName}

                    </span>

                    <span>

                        #{build.buildNumber}

                    </span>

                    <span>

                        {build.branch}

                    </span>

                    <span>

                        <a
                            href={`https://github.com/Vamsi1807/Students_api_project/commit/${build.commitId}`}
                            target="_blank"
                            rel="noreferrer"
                        >

                            {build.commitId.substring(0,7)}

                        </a>

                    </span>

                    <span>

                        {new Date(build.buildTime).toLocaleString()}

                    </span>

                    <span>

                        {build.duration} ms

                    </span>

                </div>

            ))}

        </div>

    );

}