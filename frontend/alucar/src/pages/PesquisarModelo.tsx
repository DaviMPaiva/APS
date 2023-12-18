import { useContext, useEffect, useState } from "react";
import Header from "../components/Header";
import { AlucarContext } from "../contexts/AlucarContext";

export default function PesquisarModelo() {

    const [modelo, setModelo] = useState('');
    const { getCarroPorModelo, pesquisaModelo } = useContext(AlucarContext);

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setModelo(event.target.value);
    }

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        console.log(modelo);
        getCarroPorModelo(modelo);
    }

    useEffect(() => {
        console.log(pesquisaModelo);
    },[pesquisaModelo])

    return (
        <div className="flex flex-col m-6 items-center">
            <Header />
            <div className="flex flex-col items-center gap-4">
                <p className="font-semibold">Pesquise o modelo do seu carro aqui!</p>
                <form onSubmit={handleSubmit}>
                    <div className="flex gap-4">
                        <input type="text" className="p-3 rounded" onChange={handleChange}/>
                        <button type="submit" className="p-3 bg-yellow-300 hover:bg-yellow-500 text-gray-900 rounded">Enviar</button>
                    </div>
                </form>
                {pesquisaModelo.length > 0 &&
                    <div>
                        {pesquisaModelo.map((car, index) => (
                            <div key={index} className="flex gap-3 my-4">
                                <img src={car.linkFotos} alt="Imagem" className="max-w-[200px]"/>
                                <div>
                                    <p>Modelo: {car.modelo} </p>
                                    <p>Placa: {car.placa} </p>
                                    <p>Ano: {car.ano} </p>
                                    <p>Preço: {car.preco} </p>
                                    <p>Transmissão: {car.transmissao} </p>
                                </div>
                            </div>
                        ))}
                    </div>
                }
            </div>
        </div>
    )
}