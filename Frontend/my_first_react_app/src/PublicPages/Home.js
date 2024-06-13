import React from "react";
import TicTacToe from "../TicTacToe";
import "./../CSS/home.css";

const Home = () => {
  return (
    <div className="home-container">
      <h1 className="Boreded-Text">Willkommen zu ELSA</h1>
      <p className="Boreded-Text">Organisieren Sie Ihren schulischen Alltag!</p>
      <div>
      <TicTacToe /> {/* Rendern der TicTacToe-Komponente hier */}
      </div>
      <div className="home-containerImage">

      </div>
    </div>
  );
};

export default Home;
