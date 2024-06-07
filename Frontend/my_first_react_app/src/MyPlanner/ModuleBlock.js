import React from "react";
import "./../CSS/MyPlannerCSS/ModuleBlock.css";
import Mario from "./Mario";

export function ModuleBlock({ module, isOpen, toggleModuleOpen, showMario }) {
  return (
    <div className={`module-block ${isOpen ? "open" : ""}`} onClick={toggleModuleOpen}>
      <div className="module-header">
        <div className="module-header-title">
          {showMario && <Mario className="mario-block" />} {/* Überprüfe, ob der Mario für diesen Tag angezeigt werden soll */}
          <h3>{module.moduleName}</h3>
        </div>
        <div className="module-header-toggle">{isOpen ? "-" : "+"}</div>
      </div>
      {isOpen && (
        <div className="module-details">
          <p className="module-description">{module.moduleDescription}</p>
          <table className="sidequest-table">
            <thead>
              <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Day</th>
                <th>Time</th>
                <th>Week</th>
                <th>Deadline</th>
                <th>Status</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {module.sideQuests.map((sq) => (
                <tr
                  key={sq.sqId}
                  className={sq.userSqStatusFinish ? "finished" : "in-progress"}
                >
                  <td>{sq.sqName}</td>
                  <td>{sq.sqDescription}</td>
                  <td>{sq.sqDay}</td>
                  <td>{sq.sqTime}</td>
                  <td>{sq.sqWeek}</td>
                  <td>{new Date(sq.sqDeadline).toLocaleDateString()}</td>
                  <td>{sq.userSqStatusFinish ? "Finished" : "In Progress"}</td>
                  <td>
                    <button className="btn btn-success">Finish</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}
