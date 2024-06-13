import React, { useState, useEffect } from "react";
import axios from "axios";
import "./../CSS/MyPlannerCSS/SideQuestList.css";

const API_URL = "http://localhost:8080/sqs/filteredByWeekAndDay";

const SideQuestList = ({ module, onBack }) => {
  const [sideQuests, setSideQuests] = useState([]);

  useEffect(() => {
    fetchSideQuests();
  }, []);

  const fetchSideQuests = async () => {
    try {
      const response = await axios.get(API_URL, {
        params: {
          username: "Admin",
          week: "Week 1",
          day: module.sideQuest.module.moduleDay,
        },
      });

      setSideQuests(response.data);
    } catch (error) {
      console.error("Error fetching side quests:", error);
    }
  };

  if (!sideQuests || sideQuests.length === 0) {
    return (
      <div className="sidequest-list">
        <button onClick={onBack} className="sidequest-btn sidequest-btn-secondary sidequest-btn-back">Back</button>
        <h2>{module.sideQuest.module.moduleName} - Side Quests</h2>
        <p>Keine Side Quests vorhanden.</p>
      </div>
    );
  }

  return (
    <div className="sidequest-list">
      <button onClick={onBack} className="sidequest-btn sidequest-btn-secondary sidequest-btn-back">Back</button>
      <h2>{module.sideQuest.module.moduleName} - Side Quests</h2>
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
          {sideQuests.map((sq) => (
            <tr
              key={sq.sideQuest.sqId}
              className={sq.userSqStatusFinish ? "finished" : "in-progress"}
            >
              <td>{sq.sideQuest.sqName}</td>
              <td>{sq.sideQuest.sqDescription}</td>
              <td>{sq.sideQuest.sqDay}</td>
              <td>{sq.sideQuest.sqTime}</td>
              <td>{sq.sideQuest.sqWeek}</td>
              <td>{new Date(sq.sideQuest.sqDeadline).toLocaleDateString()}</td>
              <td>{sq.userSqStatusFinish ? "Finished" : "In Progress"}</td>
              <td>
                <button className="sidequest-btn sidequest-btn-success">Finish</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default SideQuestList;
