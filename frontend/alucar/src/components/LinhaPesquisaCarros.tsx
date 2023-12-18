import { Car } from "../types";

interface LinhaPesquisaCarrosProps {
    Carro: Car;
}
export default function LinhaPesquisaCarros({ Carro }: LinhaPesquisaCarrosProps) {
    return (
        <div className="flex gap-4 p-3 justify-between border border-gray-400 rounded bg-gray-200 drop-shadow">
            <div className="flex flex-col gap-2">
                <img src={Carro.linkFotos} alt="" className="max-w-[200px] h-48 object-cover rounded"/>
            </div>
            <div className="flex flex-col gap-2 text-preto">
                <p className="font-semibold">Modelo: {Carro.modelo}</p>
                <p className="font-semibold">Placa: {Carro.placa}</p>
                <p className="font-semibold">Preço: {Carro.preco}</p>
                <p className="font-semibold">Ano: {Carro.ano}</p>
                <p className="font-semibold">Combustível: {Carro.combustivel}</p>
                <p className="font-semibold">Transmissão: {Carro.transmissao}</p>
            </div>
            
        </div>
    )
}