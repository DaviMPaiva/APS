import { Route, Routes } from 'react-router-dom';
import { AlucarProvider } from './contexts/AlucarContext';
import Home from './pages/Home';
import Historico from './pages/Historico';
import Reservar from './pages/Reservar';
import PesquisarModelo from './pages/PesquisarModelo';

function App() {
    
    return (
    <>
        <AlucarProvider>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path='/historico' element={<Historico/>}/>
                <Route path='/reservar' element={<Reservar/>}/>
                <Route path='/pesquisar-modelo' element={<PesquisarModelo/>}/>
            </Routes> 
        </AlucarProvider>
    </>

    )
}

export default App
