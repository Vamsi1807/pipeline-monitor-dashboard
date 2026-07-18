import { BrowserRouter, Routes, Route } from "react-router-dom";

import Dashboard from "./pages/Dashboard";
import BuildDetails from "./pages/BuildDetails";
import ProjectDetails from "./pages/ProjectDetails";

function App() {

    return (

        <BrowserRouter>

            <Routes>

                <Route
                    path="/"
                    element={<Dashboard />}
                />

                <Route
                    path="/build/:id"
                    element={<BuildDetails />}
                />

                <Route
                    path="/project/:projectName"
                    element={<ProjectDetails />}
                />

            </Routes>

        </BrowserRouter>

    );

}

export default App;