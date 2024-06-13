import React, { useState, useEffect } from "react";
import axios from "axios";
import ModuleBlock from "./ModuleBlock";
import SideQuestList from "./SideQuestList"; // Hinweis: Der Import ist jetzt 'SideQuestList' statt '{ SideQuestList }'
import "./../CSS/MyPlannerCSS/ModuleDisplay.css";
import Mario from "./Mario";

const API_URL = "http://localhost:8080/sqs/filteredByWeekAndDay";

const ModuleDisplay = () => {
  const [modules, setModules] = useState([]);
  const [selectedModule, setSelectedModule] = useState(null);
  const showMarioOnDay = "Tuesday"; // Ändere dies bei Bedarf

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    const weekdays = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"];

    try {
      const promises = weekdays.map(async (day) => {
        const response = await axios.get(API_URL, {
          params: {
            username: "Admin",
            week: "Week 1",
            day: day,
          },
        });
        return response.data;
      });

      const results = await Promise.all(promises);
      const allModules = results.flat(); // Flattet das Array von Arrays in ein einzelnes Array

      console.log("API response for all weekdays:", allModules);
      setModules(allModules);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const handleModuleClick = (module) => {
    setSelectedModule(module);
  };

  const handleBack = () => {
    setSelectedModule(null);
  };

  const groupedModules = modules.reduce((acc, module) => {
    acc[module.sideQuest.module.moduleDay] = [
      ...(acc[module.sideQuest.module.moduleDay] || []),
      module,
    ];
    return acc;
  }, {});

  return (
    <div className="module-display">
      {selectedModule ? (
        <SideQuestList module={selectedModule} onBack={handleBack} />
      ) : (
        Object.entries(groupedModules).map(([day, dayModules]) => (
          <div key={day} className="module-section">
            {day === showMarioOnDay && <Mario className="Mario" />}
            <h3 className="module-day">{day}</h3>
            <div className="module-list">
              {dayModules.map((module, index) => (
                <ModuleBlock
                  key={module.id}
                  module={module}
                  onModuleClick={handleModuleClick}
                  small={index % 2 !== 0} // Beispiel: Jedes zweite Modul ist kleiner
                />
              ))}
            </div>
          </div>
        ))
      )}
    </div>
  );
};

export default ModuleDisplay;
