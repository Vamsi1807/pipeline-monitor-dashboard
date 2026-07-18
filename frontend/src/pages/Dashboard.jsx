import styles from "./Dashboard.module.css";

import SummaryCard from "../components/SummaryCard/SummaryCard";
import LatestBuild from "../components/LatestBuild/LatestBuild";
import RecentFailures from "../components/RecentFailures/RecentFailures";
import BuildActivityFeed from "../components/BuildActivityFeed/BuildActivityFeed";

export default function Dashboard() {

    return (

        <div className={styles.dashboard}>

            <header className={styles.header}>

                <h1>🚀 CI/CD Pipeline Monitoring Dashboard</h1>

                <span>Last Updated : --</span>

            </header>

            <main className={styles.content}>

                <aside className={styles.leftPanel}>

                    <SummaryCard />

                    <LatestBuild />

                    <RecentFailures />

                </aside>

                <section className={styles.rightPanel}>
                    <BuildActivityFeed />
                </section>

            </main>

        </div>

    );

}