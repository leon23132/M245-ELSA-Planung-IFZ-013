import React from "react";
import "./../CSS/home.css";
import background from "../Images/background.jpg"; // Import the background image

const Home = () => {
  return (
    <div className="home-container" style={{
      backgroundImage: `url(${background})`,
      borderRadius: '20px', // Adjust the radius value as per your design
    }}>
      <h1>Willkommen zu ELSA</h1>
      <p>Die bessere alternatieve zu Tocco!</p>
      <div className="home-containerImage">
        {/* You can add more content inside this div if needed */}
      </div>
    </div>
  );
};

export default Home;