import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

import api from "../services/api";
import ROUTES from "../constants/routes";
import { formatDate, formatDuration } from "../utils/date";
import { getCommitUrl, getBranchUrl } from "../utils/github";

import "./BuildDetails.css";

export default function BuildDetails() {

    const { id } = useParams();

    const [build, setBuild] = useState(null);

    useEffect(() => {

        loadBuild();

    }, [id]);

    async function loadBuild() {

        try {

            const response = await api.get(`/builds/${id}`);

            setBuild(response.data);

        }

        catch (error) {

            console.error(error);

        }

    }

    if (!build) {

        return <h2 style={{ padding: "40px" }}>Loading...</h2>;

    }

    return (

        <div className="details-page">

            <Link
                className="back-link"
                to={ROUTES.HOME}
            >
                ← Dashboard
            </Link>

            <div className="details-card">

                <h1>

                    {build.jobName}

                </h1>

                <span
                    className={
                        build.status === "SUCCESS"
                            ? "success"
                            : "failure"
                    }
                >
                    {build.status}
                </span>

                <div className="info-grid">

                    <div>

                        <label>Build Number</label>

                        <p>#{build.buildNumber}</p>

                    </div>

                    <div>

                        <label>Branch</label>

                        <a
                            href={getBranchUrl(build.branch)}
                            target="_blank"
                        >
                            {build.branch}
                        </a>

                    </div>

                    <div>

                        <label>Commit</label>

                        <a
                            href={getCommitUrl(build.commitId)}
                            target="_blank"
                        >
                            {build.commitId.substring(0, 7)}
                        </a>

                    </div>

                    <div>

                        <label>Duration</label>

                        <p>

                            {formatDuration(build.duration)}

                        </p>

                    </div>

                    <div>

                        <label>Build Time</label>

                        <p>

                            {formatDate(build.buildTime)}

                        </p>

                    </div>

                </div>

                <div className="buttons">

                    {
                        build.buildUrl &&

                        <a
                            href={build.buildUrl}
                            target="_blank"
                        >
                            Open Jenkins
                        </a>
                    }

                    {
                        build.consoleUrl &&

                        <a
                            href={build.consoleUrl}
                            target="_blank"
                        >
                            Console Log
                        </a>
                    }

                </div>

            </div>

        </div>

    );

}