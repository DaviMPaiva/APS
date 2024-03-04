import { useContext, useEffect, useState } from "react";
import Header from "../components/Header";
import { Reserva, Cartao } from "../types";
import { AlucarContext } from "../contexts/AlucarContext";
import { useNavigate, useParams } from "react-router-dom";
import { Car } from "../types";

export default function Reservar() {

    const [dataInicio, setDataInicio] = useState<string>();
    const [dataTermino, setDataTermino] = useState<string>();
    const [numeroCartao, setNumeroCartao] = useState<string>();
    const [nomeCartao, setNomeCartao] = useState<string>();
    const [cvcCartao, setCvcCartao] = useState<string>();
    const [validadeCartao, setValidadeCartao] = useState<string>();
    const [carro, setCarro] = useState<Car>();
    const { placa } = useParams();

    const { reservarCarro, getCarroByPlaca } = useContext(AlucarContext);
    const navigate = useNavigate();

    useEffect(() => {
        const getCar = async () => {
            if (placa == undefined) {
                return
            }
            const auxCar = await getCarroByPlaca(placa);
            setCarro(auxCar);
        }

        getCar();
    }, [placa])

    const criarReserva = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        if (dataInicio === undefined || dataTermino === undefined || numeroCartao === undefined || nomeCartao === undefined || cvcCartao === undefined || validadeCartao === undefined) {
            alert("Preencha todas as informações para prosseguir com a reserva!");
            return;
        } else {
            const reserva: Reserva = {
                valor: 150,
                carro: "GHI9012",
                dataInicio: dataInicio,
                dataTermino: dataTermino,
                taxa: 0,
                usuario: "joao@email.com"
            }
            const cartao: Cartao = {
                numero: numeroCartao,
                titular: nomeCartao,
                dataValidade: validadeCartao,
                cvc: cvcCartao
            
            }
            reservarCarro(reserva, cartao);
            navigate("/reserva-solicitada");
        }
        
    }

    return (
        <div className="flex flex-col m-6 items-center">
            <Header/>
            <div className="flex flex-col gap-4 items-center">
                <p className="font-semibold text-lg">Reserve seu {carro?.modelo}</p>
                <img src={carro?.linkFotos} alt={carro?.modelo} className="rounded-sm max-w-sm" />
                <p className="font-semibold text-xl">Informações do carro</p>
                <div className="flex flex-col gap-2 bg-white text-black w-full p-3 rounded-md">
                    <p>Modelo: {carro?.modelo}</p>
                    <p>Placa: {carro?.placa}</p>
                    <p>Preço: {carro?.preco}</p>
                    <p>Ano: {carro?.ano}</p>
                    <p>Combustível: {carro?.combustivel}</p>
                    <p>Transmissão: {carro?.transmissao}</p>
                </div>
                <form onSubmit={criarReserva} className="flex flex-col items-center gap-5">
                    <div className="flex gap-4">
                        <div className="flex flex-col">
                            <label htmlFor="">Data de início:</label>
                            <input type="date" className="p-3 rounded text-gray-900" onChange={(event) => setDataInicio(new Date(event.target.value).toISOString().slice(0, 10))}/>
                        </div>
                        <div className="flex flex-col">
                            <label htmlFor="">Data de devolução:</label>
                            <input type="date" className="p-3 rounded text-gray-900" onChange={(event) => setDataTermino(new Date(event.target.value).toISOString().slice(0, 10))}/>
                        </div>
                    </div>
                    
                    <p className="text-xl">Informações de Pagamento</p>
                    <div className="grid grid-cols-2 gap-4">
                        <div className="flex flex-col">
                            <label htmlFor="">Número do cartão:</label>
                            <input type="text" className="p-3 rounded" onChange={(event) => setNumeroCartao(event.target.value)}/>
                        </div>
                        <div className="flex flex-col">
                            <label htmlFor="">Nome no cartão:</label>
                            <input type="text" className="p-3 rounded" onChange={(event) => setNomeCartao(event.target.value)}/>
                        </div>
                        <div className="flex flex-col">
                            <label htmlFor="">Data de validade (mês/ano):</label>
                            <input type="text" className="p-3 rounded" onChange={(event) => setValidadeCartao(event.target.value)}/>
                        </div>
                        <div className="flex flex-col">
                            <label htmlFor="">CVC:</label>
                            <input type="text" className="p-3 rounded" onChange={(event) => setCvcCartao(event.target.value)}/>
                        </div>
                    </div>
                    <button type="submit" className="p-3 bg-blue-300 hover:bg-blue-500 text-gray-900 rounded ">Solicitar Reserva</button>
                </form>
            </div>
        </div>
    )
}