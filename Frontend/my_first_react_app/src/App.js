import React from 'react';
import './App.css';
import { GlobalNavigation } from './GlobalNavigation'; // Stellen Sie sicher, dass der Pfad korrekt ist
import HomeImage from './Images/LogoImage.jpg';
import ELSA from './Images/ELSA.jpg';

function App() {
    return (
        <div className="App">
            <header className="bg-dark text-white text-center h4 p-2">
                
            </header>
            <body className='Body-App'>
                <div className='Bodie-Todo'>
                    <img src={ELSA} alt='Beschreibung des Bildes' width="50" height="33" className='LogoImage' />

                    <GlobalNavigation />

                </div>
            </body>
            <footer className="footer">
                <div>
                    {/* Hier kannst du den Inhalt deines Footers einfügen */}
                    &copy; {new Date().getFullYear()} ELSA App. Alle Rechte vorbehalten.
                </div>
            </footer>

        </div >
    );
}

export default App;
