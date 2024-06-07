import React, { useState, useEffect } from 'react';
import MarioImage1 from './../anImages/Mario/MarioImage_1.png';
import './../CSS/MyPlannerCSS/Mario.css';
import MarioImage2 from './../anImages/Mario/MarioImage_2.png';
import MarioImage3 from './../anImages/Mario/MarioImage_3.png';
import MarioImage4 from './../anImages/Mario/MarioImage_4.png';
import MarioImage5 from './../anImages/Mario/MarioImage_5.png';

function Mario() {
    const [currentImage, setCurrentImage] = useState(MarioImage1);
    const [isAnimating, setIsAnimating] = useState(false);
    const [animationSpeed, setAnimationSpeed] = useState(500); // Default animation speed
    const [frameDuration, setFrameDuration] = useState(1000); // Duration to display each frame

    const images = [MarioImage1, MarioImage2, MarioImage3, MarioImage4, MarioImage5];

    useEffect(() => {
        if (isAnimating) {
            startAnimation();
        }
    }, [isAnimating]);

    const startAnimation = () => {
        setIsAnimating(true);
        let index = 0;
        const id = setInterval(() => {
            setCurrentImage(images[index]);
            index = (index + 1) % images.length;
            if (index === 0) {
                setTimeout(() => {
                    setIsAnimating(false);
                    setCurrentImage(MarioImage1);
                }, frameDuration);
                clearInterval(id);
            }
        }, animationSpeed);
    };

    return (
        <div>
            <div className="ImageContainer">
                <img src={currentImage} alt="Super Mario" className="MarioImage" />
            </div>
            <div className="ButtonsContainer">
                {!isAnimating && <button onClick={startAnimation}>Start Animation</button>}
            </div>
        </div>
    );
}

export default Mario;
