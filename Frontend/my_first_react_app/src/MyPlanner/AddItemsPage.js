import React, { useEffect, useState } from "react";
import axios from "axios";
import "./../CSS/MyPlannerCSS/AddItemsPage.css";
import fetchData from './FetchingData'; // Pfad zur fetchData-Datei anpassen
const AddItemsPage = () => {
  const [showNewModule, setShowNewModule] = useState(false);
  const [showNewSidequest, setShowNewSidequest] = useState(false);
  const [showNewUserSidequest, setShowNewUserSidequest] = useState(false);



  // Zustände für Modul hinzufügen
  const [moduleName, setModuleName] = useState("");
  const [moduleDay, setModuleDay] = useState("");
  const [moduleDescription, setModuleDescription] = useState("");
  const [moduleId, setModuleId] = useState(null); // Zustand für Modul-ID

  // Zustände für Sidequest hinzufügen
  const [sidequestName, setSidequestName] = useState("");
  const [sidequestDescription, setSidequestDescription] = useState("");
  const [sidequestDay, setSidequestDay] = useState("");
  const [sidequestTime, setSidequestTime] = useState("");
  const [sidequestWeek, setSidequestWeek] = useState("");
  const [sidequestDeadline, setSidequestDeadline] = useState("");

  //Fetching Modules to Select

  const [ModuelesData, setModulesData] = useState([]);
  const [SelectetModule, setSelectetModule] = useState(null);
  const token = localStorage.getItem.token;
  const url = "http://localhost:8080/sqs/modules/all";

  //All SideQuest And User
  const [SideQuestsData, setSidequestData] = useState([]);
  const [SelectetSidequest, setSelectetSidequest] = useState(null);
  const [UserData, setUserData] = useState([]);
  const [SelectetUser, setSelectetUser] = useState(null);
  const usersqadd = "http://localhost:8080/sqs/usersq/add";
  const allSidequests = "http://localhost:8080/sqs/sidequests/all";
  const allUsers = "http://localhost:8080/sqs/users/all";



  const daysOfWeek = [
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday"
  ];

  const handleToggleNewModule = () => {
    setShowNewModule(!showNewModule);
    setShowNewSidequest(false); // Sidequest Formular ausblenden, wenn Modul Formular angezeigt wird
    setShowNewUserSidequest(false)
  };

  const handleToggleNewSidequest = () => {
    setShowNewSidequest(!showNewSidequest);
    setShowNewModule(false); // Modul Formular ausblenden, wenn Sidequest Formular angezeigt wird
  };

  const handleToggleNewUserSidequest = () => {
    setShowNewUserSidequest(!showNewUserSidequest);
    setShowNewModule(false); // Sicherstellen, dass das Modul-Formular ausgeblendet wird
    setShowNewSidequest(false); // Sicherstellen, dass das Sidequest-Formular ausgeblendet wird
  };

  useEffect(() => {
    console.log(`Current Selected Module State:`, SelectetModule);
  }, [SelectetModule, SelectetUser, SelectetSidequest]);


  const handleModuleChange = (event) => {
    try {
      const newValue = event.target.value;
      const selectetModule = ModuelesData.find(m => m.moduleName === newValue)

      if (selectetModule) {
        setSelectetModule(selectetModule)
        console.log(`Selected Module: ${selectetModule.moduleName} (${selectetModule.modulId})`);
      } else {
        console.log("Module not found in ModuelesData");
      }
      console.log(SelectetModule);
    } catch (error) {
      console.log("Error Selector Modules");
    }



  };

  const handleUserChange = (event) => {
    try {
      const newUValue = event.target.value;
      const selectedUser = UserData.find(u => u.username === newUValue)

      if (selectedUser) {
        setSelectetUser(selectedUser)
        console.log(`Selected User: ${selectedUser.username} (${selectedUser.id})`);
      } else {
        console.log("User not found in UserData");
      }
      console.log(selectedUser);
    } catch (error) {
      console.log("Error Selector Data");
    }



  };

  const handleSideQuestChange = (event) => {
    try {
      const newSValue = event.target.value;
      const selectetSidequest = SideQuestsData.find(s => s.sqName === newSValue);
      console.log(newSValue);
      if (selectetSidequest) {
        setSelectetSidequest(selectetSidequest)
        console.log(`Selected SideQuest: ${selectetSidequest.sqName} (${selectetSidequest.sqId})`);
      } else {
        console.log("SideQuest not found in SideQuestData");
      }
      console.log(selectetSidequest);
    } catch (error) {
      console.log("Error Selector Data");
    }



  };


  useEffect(() => {
    const fetchDataAsync = async () => {

      try {
        //Data
        await fetchData(url, setModulesData, token);
        console.log(ModuelesData);
        console.log("Request Modules Loaded");

      } catch (error) {
        console.log("Error Loading Modules for Selector");
      }

      try {
        await fetchData(allUsers, setUserData, token);
        console.log("Users Loaded");
      } catch (error) {
        console.log("Error Loading Users for Selector");
      }

      try {
        await fetchData(allSidequests, setSidequestData, token);
        console.log("Sidequests Loaded");
      } catch (error) {
        console.log("Error Loading Sdiequests for Selector");
      }
    };
    fetchDataAsync();

  }, [url, token]);





  const handleSaveModule = async () => {
    try {
      const token = "your_bearer_token_here"; // Setzen Sie Ihren Bearer-Token hier ein

      const headers = {
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/json"
      };

      const apiUrl = "http://localhost:8080/sqs/modules/add";
      const requestBody = {
        moduleName: moduleName,
        moduleDescription: moduleDescription,
        moduleDay: moduleDay
      };

      const response = await axios.post(apiUrl, requestBody, { headers });

      console.log("Response after saving module:", response.data);

      // Setzen der Modul-ID nach dem Speichern
      setModuleId(response.data.moduleId);

      // Zurücksetzen der Eingabefelder nach dem Speichern
      setModuleName("");
      setModuleDay("");
      setModuleDescription("");

      // Optional: Hier können Sie Benachrichtigungen oder andere Logik hinzufügen, um den Benutzer zu informieren
    } catch (error) {
      console.error("Error saving module:", error);
      // Optional: Hier können Sie Fehlerbehandlung hinzufügen, um dem Benutzer Feedback zu geben
    }
  };

  const handleSaveUserSQ = async () => {
    try {

      const headers = {
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/json"
      };

      console.log("Hl");
console.log(SelectetSidequest);

      const requestBody = {
        user: {
          id: SelectetUser.id
        },
        sideQuest: {
          sqId: SelectetSidequest.sqId
        },
        userSqStatus: 1,
        userSqStatusFinish: 0,
        userSqStatusStr: 0
      };

      console.log(requestBody);



      const response = await axios.post(usersqadd, requestBody, { headers });

      console.log("Response after saving UserSQ:", response.data);

   
    } catch (error) {
      console.error("Error saving sidequest:", error);
      // Optional: Hier können Sie Fehlerbehandlung hinzufügen, um dem Benutzer Feedback zu geben
    }
  };

  const handleSaveSidequest = async () => {
    try {

      const headers = {
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/json"
      };

      const apiUrl = "http://localhost:8080/sqs/sidequests/add";
      const requestBody = {
        sqName: sidequestName,
        sqDescription: sidequestDescription,
        sqDay: sidequestDay,
        sqTime: sidequestTime,
        sqWeek: sidequestWeek,
        sqDeadline: sidequestDeadline,
        module: {
          modulId: SelectetModule.modulId,
          moduleName: SelectetModule.moduleName,
          moduleDescription: SelectetModule.moduleDescription,
          moduleDay: SelectetModule.moduleDay
        }
      };

      const response = await axios.post(apiUrl, requestBody, { headers });

      console.log("Response after saving sidequest:", response.data);

      // Zurücksetzen der Eingabefelder nach dem Speichern
      setSidequestName("");
      setSidequestDescription("");
      setSidequestDay("");
      setSidequestTime("");
      setSidequestWeek("");
      setSidequestDeadline("");

      // Optional: Hier können Sie Benachrichtigungen oder andere Logik hinzufügen, um den Benutzer zu informieren
    } catch (error) {
      console.error("Error saving sidequest:", error);
      // Optional: Hier können Sie Fehlerbehandlung hinzufügen, um dem Benutzer Feedback zu geben
    }
  };

  return (
    <div className="add-items-page">
      <h2>Elemente hinzufügen</h2>
      <div className="add-items-buttons">
        <button onClick={handleToggleNewModule} className="add-item-btn">
          Neues Modul
        </button>
        <button onClick={handleToggleNewSidequest} className="add-item-btn">
          Neue Sidequest
        </button>
        <button onClick={handleToggleNewUserSidequest} className="add-item-btn">
          Neuer User zu Sidequest
        </button>
      </div>

      {/* Formular für Neues Modul */}
      {showNewModule && (
        <div className="new-module-form">
          <input
            type="text"
            placeholder="Modul Name"
            value={moduleName}
            onChange={(e) => setModuleName(e.target.value)}
            className="input-field"
          />
          <select
            value={moduleDay}
            onChange={(e) => setModuleDay(e.target.value)}
            className="select-day"
          >
            <option value="">Modul Tag auswählen</option>
            {daysOfWeek.map((day, index) => (
              <option key={index} value={day}>
                {day}
              </option>
            ))}
          </select>
          <textarea
            placeholder="Modul Beschreibung"
            value={moduleDescription}
            onChange={(e) => setModuleDescription(e.target.value)}
            className="textarea-field"
          ></textarea>
          <button onClick={handleSaveModule} className="save-item-btn">
            Modul Speichern
          </button>
        </div>
      )}

      {/* Formular für Neue Sidequest */}
      {showNewSidequest && (
        <div className="new-sidequest-form">
          <input
            type="text"
            placeholder="Sidequest Name"
            value={sidequestName}
            onChange={(e) => setSidequestName(e.target.value)}
            className="input-field"
          />
          <textarea
            placeholder="Sidequest Beschreibung"
            value={sidequestDescription}
            onChange={(e) => setSidequestDescription(e.target.value)}
            className="textarea-field"
          ></textarea>
          <select
            value={sidequestDay}
            onChange={(e) => setSidequestDay(e.target.value)}
            className="select-day"
          >
            <option value="">Sidequest Tag auswählen</option>
            {daysOfWeek.map((day, index) => (
              <option key={index} value={day}>
                {day}
              </option>
            ))}
          </select>
          {/*Module Selector*/}
          <select
            value={SelectetModule ? SelectetModule.id : ''}
            onChange={handleModuleChange}
            className="select-day">

            {ModuelesData.map(item => (
              <option key={item.moduleId} value={item.moduleId}
              >{item.moduleName}</option>
            ))}
          </select>
          <input
            type="time"
            placeholder="Sidequest Zeit"
            value={sidequestTime}
            onChange={(e) => setSidequestTime(e.target.value)}
            className="input-field"
          />
          <input
            type="number"
            placeholder="Sidequest Woche"
            value={sidequestWeek}
            onChange={(e) => setSidequestWeek(e.target.value)}
            className="input-field"
          />
          <input
            type="date"
            placeholder="Sidequest Deadline"
            value={sidequestDeadline}
            onChange={(e) => setSidequestDeadline(e.target.value)}
            className="input-field"
          />
          <button onClick={handleSaveSidequest} className="save-item-btn">
            Sidequest Speichern
          </button>
        </div>
      )}

      {/* Formular für Neues Modul */}
      {showNewModule && (
        <div className="new-SideQuestUser-form">
          <input
            type="text"
            placeholder="Modul Name"
            value={moduleName}
            onChange={(e) => setModuleName(e.target.value)}
            className="input-field"
          />
          <select
            value={moduleDay}
            onChange={(e) => setModuleDay(e.target.value)}
            className="select-day"
          >
            <option value="">Modul Tag auswählen</option>
            {daysOfWeek.map((day, index) => (
              <option key={index} value={day}>
                {day}
              </option>
            ))}
          </select>
          <textarea
            placeholder="Modul Beschreibung"
            value={moduleDescription}
            onChange={(e) => setModuleDescription(e.target.value)}
            className="textarea-field"
          ></textarea>
          <button onClick={handleSaveModule} className="save-item-btn">
            Modul Speichern
          </button>
        </div>
      )}


      {/* Formular für UserSQ */}
      {showNewUserSidequest && (
        <div className="new-module-form">
          {/*User Selector*/}
          <select
            value={SelectetUser ? SelectetUser.id : ''}
            onChange={handleUserChange}
            className="select-day">

            {UserData.map(item => (
              <option key={item.id} value={item.username}
              >{item.username}</option>
            ))}
          </select>


          {/*SideQuest Selector*/}
          <select
            value={SelectetSidequest ? SelectetSidequest.id : ''}
            onChange={handleSideQuestChange}
            className="select-day">

            {SideQuestsData.map(item => (
              <option key={item.sqId} value={item.sqName}
              >{item.sqName}</option>
            ))}
          </select>
          <button onClick={handleSaveUserSQ} className="save-item-btn">
            Zuweisung Speichern
          </button>
        </div>
      )}

    </div>
  );
};

export default AddItemsPage;
