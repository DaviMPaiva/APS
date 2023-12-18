import { useContext, useState } from 'react';
import { AlucarContext } from '../contexts/AlucarContext';
import { Link } from 'react-router-dom';

export default function Historico() {

    const [count, setCount] = useState(0)
    const { historico, getHistorico, } = useContext(AlucarContext);
    const handleHistorico = () => {
        setCount(count + 1);
        getHistorico();
    }
    
    return (
        <>
            <Link to={`/`}>
                <div className='flex justify-center font-sans text-2xl font-bold pt-4'>Alucar</div>
            </Link>
            <div  className='flex flex-col items-center mt-4'>
            <button onClick={ handleHistorico } className='my-4'>
                    <p className='rounded-full bg-blue-500 text-white px-3 hover:bg-blue-600 hover:cursor-pointer ease-in-out duration-300'>Visualizar Histórico de Carros - { count }</p>
            </button>
                {count > 0 && <div>
                    {historico.map((reserva, index) => (
                        <div key={index} className="flex flex-col gap-3 my-4">
                            <p>Placa: {reserva.carro} </p>
                            <p>Valor: {reserva.valor} </p>
                            <p>Tempo: { reserva.dataInicio.toString() } - { reserva.dataTermino.toString() }</p>
                            <p>Taxa extra: {reserva.taxa}</p>
                        </div>
                    ))}
                </div>}
            </div>
        </>
       
    )
}