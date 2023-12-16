import { Route, Routes } from 'react-router-dom';
import { AlucarProvider } from './contexts/AlucarContext';
import Home from './pages/Home';
import Historico from './pages/Historico';

function App() {
    
    return (
    <>
        <AlucarProvider>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path='/historico' element={<Historico/>}/>
            </Routes> 
        </AlucarProvider>
    </>

    )
}

export default App
