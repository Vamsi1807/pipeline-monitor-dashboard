import { useParams } from "react-router-dom";

export default function ProjectDetails() {

    const { projectName } = useParams();

    return (

        <div style={{ padding: "30px" }}>

            <h1>Project Details</h1>

            <h2>{projectName}</h2>

        </div>

    );

}