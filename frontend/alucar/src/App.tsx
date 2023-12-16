import { useState, useContext } from 'react'
import { AlucarContext } from './contexts/AlucarContext'

function App() {
    const [count, setCount] = useState(0)
    const { imageLink, getImageLink } = useContext(AlucarContext);
    const handleImageLink = () => {
        setCount(count + 1);
        getImageLink();
    }
    return (
    
    <>
        <div className='flex justify-center font-sans text-xl font-bold pt-4'>Alucar</div>
        <div  className='flex flex-col items-center mt-4'>
            <img src={ imageLink } alt="Imagem" />
            <button onClick={ handleImageLink } className='mt-2'>
                <p className='rounded-full bg-blue-500 text-white px-3 hover:bg-blue-600 hover:cursor-pointer ease-in-out duration-300'>Get another image - { count }</p>
            </button>
        </div>

    </>

    )
}

export default App
