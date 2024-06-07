import React, { useState } from "react";
import { ModuleBlock } from "./ModuleBlock";
import "./../CSS/MyPlannerCSS/ModuleDisplay.css";
import { moduleData } from "./moduleData";
import Mario from "./Mario";

export default function ModuleDisplay() {
  const [modules, setModules] = useState(moduleData);
  const showMarioOnDay = "Monday"; // Ändere dies entsprechend

  const toggleModuleOpen = (moduleId) => {
    setModules((prevModules) =>
      prevModules.map((module) => {
        if (module.id === moduleId) {
          return { ...module, isOpen: !module.isOpen };
        }
        return module;
      })
    );
  };

  // Gruppiere Module nach Tagen
  const groupedModules = modules.reduce((acc, module) => {
    acc[module.moduleDay] = [...(acc[module.moduleDay] || []), module];
    return acc;
  }, {});

  return (
    <div className="module-display">
      {/* Rendere den Mario über der Modulansicht, aber nur an dem Tag, der in showMarioOnDay definiert ist */}
      {Object.keys(groupedModules).includes(showMarioOnDay) && (
        <Mario className="full-width-mario" />
      )}

      {/* Iteriere über die Tage und rendere für jeden Tag Module */}
      {Object.entries(groupedModules).map(([day, dayModules]) => (
        <div key={day} className="module-section">
          <h3 className="module-day">{day}</h3>
          <div className="module-list">
            {/* Rendere für jedes Modul einen ModuleBlock */}
            {dayModules.map((module) => (
              <ModuleBlock
                key={module.id}
                module={module}
                isOpen={module.isOpen}
                toggleModuleOpen={() => toggleModuleOpen(module.id)}
                showMario={day === showMarioOnDay} // Übergebe den Tag an ModuleBlock
              />
            ))}
          </div>
        </div>
      ))}
    </div>
  );
}
