import React from "react";
import "./../CSS/MyPlannerCSS/ModuleBlock.css";
import Mario from "./Mario";

const ModuleBlock = ({ module, onModuleClick, small }) => {
  const { sideQuest } = module;

  const handleModuleClick = () => {
    onModuleClick(module);
  };

  return (
    <div className={`module-block ${small ? 'small-module-block' : ''}`} onClick={handleModuleClick}>
      <div className="module-header">
        <div className="module-header-title">
          {sideQuest.module.moduleDay === "Monday"}
          <h3>{sideQuest.module.moduleName}</h3>
        </div>
      </div>
    </div>
  );
};

export default ModuleBlock;
