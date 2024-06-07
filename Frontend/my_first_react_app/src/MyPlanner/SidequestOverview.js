import React from "react";
import { ModuleBlock } from "./ModuleBlock";
import './../CSS/MyPlannerCSS/SidequestOverview.css';


// Component to display an overview of all modules and their sidequests
export function SidequestOverview({ userSqs }) {
    // Group sidequests by module
    const modulesMap = userSqs.reduce((acc, userSq) => {
        const module = userSq.sideQuest.module;
        // Initialize module in the map if not already present
        if (!acc[module.modulId]) {
            acc[module.modulId] = { ...module, sideQuests: [] };
        }
        // Add sidequest to the module's sidequests array
        acc[module.modulId].sideQuests.push({ ...userSq.sideQuest, userSqStatusFinish: userSq.userSqStatusFinish });
        return acc;
    }, {});

    // Convert modules map to an array
    const modules = Object.values(modulesMap);

    return (
        <div className="sidequest-overview">
            {modules.map((module) => (
                <ModuleBlock key={module.modulId} module={module} />
            ))}
        </div>
    );
}
