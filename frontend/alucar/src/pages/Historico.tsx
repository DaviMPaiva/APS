import { useContext, useEffect, useState } from 'react';
import { AlucarContext } from '../contexts/AlucarContext';
import Header from '../components/Header';
import { Reserva } from '../types';

export default function Historico() {

    const { historico, getHistorico, } = useContext(AlucarContext);
    const handleHistorico = () => {
        getHistorico();
    }

    const reservation: Reserva = {
        valor: 150,
        carro: "GHI9012",
        dataInicio: "2021-10-10",
        dataTermino: "2021-10-11",
        taxa: 0,
        usuario: "joao@email.com"
    }

    return (
        <div className="flex flex-col m-6 items-center">
            <Header/>
            <div  className='flex flex-col items-center mt-4'>
            <button onClick={ handleHistorico } className='my-4'>
                    <p className='rounded-full bg-red-300 px-3 hover:bg-red-500 text-gray-900 hover:cursor-pointer ease-in-out duration-300'>Visualizar Histórico de Carros Reservados</p>
            </button>
                {historico.map((reserva, index) => (
                    <div key={index} className="flex flex-col gap-3 my-4 rounded bg-gray-400 text-white font-semibold p-4 drop-shadow">
                        <p>Placa: {reserva.carro} </p>
                        <p>Valor: {reserva.valor} </p>
                        <p>Tempo: { reserva.dataInicio.toString() } - { reserva.dataTermino.toString() }</p>
                        <p>Taxa extra: {reserva.taxa}</p>
                    </div>
                ))}
            </div>
        </div>
       
    )
}