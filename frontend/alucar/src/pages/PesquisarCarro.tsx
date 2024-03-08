import { useContext, useEffect, useState } from "react";
import Header from "../components/Header";
import { AlucarContext } from "../contexts/AlucarContext";
import { Car } from "../types";
import LinhaPesquisaCarros from "../components/LinhaPesquisaCarros";
import { Link } from "react-router-dom";

export default function PesquisarModelo() {

    const [dataInicio, setDataInicio] = useState('');
    const [dataTermino, setDataTermino] = useState('');
    const { getCarrosDisponiveis, pesquisaCarros, setPesquisaCarros } = useContext(AlucarContext);

    useEffect(() => {
        setPesquisaCarros([]);
    }, [dataInicio, dataTermino])

    const handleChangeDataInicio = (event: React.ChangeEvent<HTMLInputElement>) => {
        setDataInicio(event.target.value);
    }

    const handleChangeDataTermino = (event: React.ChangeEvent<HTMLInputElement>) => {
        setDataTermino(event.target.value);
    }

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        
        getCarrosDisponiveis(dataInicio, dataTermino);
    }

    return (
        <div className="flex flex-col m-6 items-center">
            <Header />
            <div className="flex flex-col items-center gap-4">
                <p className="font-semibold text-2xl">Pesquisar carros</p>
                <form onSubmit={handleSubmit} className="flex flex-col items-center gap-4">
                    <p className="mb-4 mt-1 font-semibold">Encontre carros disponíveis na data que deseja</p>
                    <div className="flex gap-4">
                        <div className="flex flex-col gap-2">
                            <label htmlFor="">Data de Início:</label>
                            <input type="date" className="p-3 rounded text-gray-900" onChange={handleChangeDataInicio}/>
                        </div>
                        <div className="flex flex-col gap-2">
                            <label htmlFor="">Data de Término:</label>
                            <input type="date" className="p-3 rounded text-gray-900" onChange={handleChangeDataTermino}/>
                        </div>
                    </div>
                    <button type="submit" className="p-3 bg-yellow-300 hover:bg-yellow-500 text-gray-900 rounded">Buscar</button>
                </form>
                <div className="grid grid-cols-3 gap-4">
                    {pesquisaCarros.map((carro, index) => (
                        <Link to={`/reservar/${carro.placa}`} state={{ datas: [dataInicio, dataTermino] }}
                            key={index} className="hover:scale-[1.02] ease-in-out duration-300">
                            <LinhaPesquisaCarros key={index} Carro={carro} />
                        </Link>
                    ))}
                </div>
            </div>
        </div>
    )
}