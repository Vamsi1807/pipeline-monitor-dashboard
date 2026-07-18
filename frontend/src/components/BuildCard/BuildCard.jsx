import styles from "./BuildCard.module.css";

export default function BuildCard() {

    return (

        <div className={styles.card}>

            <div className={styles.left}>

                <div className={styles.statusSuccess}>

                    SUCCESS

                </div>

                <h2>

                    Students-API

                </h2>

                <p>

                    Build #15

                </p>

            </div>

            <div className={styles.center}>

                <p>

                    🌿 Branch :
                    <strong> main</strong>

                </p>

                <p>

                    🔖 Commit :
                    <strong> bbc159d</strong>

                </p>

                <p>

                    🕒 2 minutes ago

                </p>

            </div>

            <div className={styles.right}>

                <button>

                    Details

                </button>

                <button className={styles.secondary}>

                    Jenkins

                </button>

            </div>

        </div>

    );

}