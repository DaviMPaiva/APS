import { Link } from "react-router-dom";
import Header from "../components/Header";

export default function Home() {

    return (
        <div className="flex flex-col m-6 items-center">
            <Header/>
            <div className="grid grid-cols-2 justify-center gap-5">
                <Link to={`/historico`}>
                    <button className="rounded-full bg-red-300 hover:bg-red-500 px-4 text-gray-900">Ver histórico</button>
                </Link>
                <Link to={`/reservar`}>
                    <button className="rounded-full bg-blue-300 hover:bg-blue-500 px-4 text-gray-900">Reservar</button>
                </Link>
                <Link to={`/pesquisar-modelo`}>
                    <button className="rounded-full bg-yellow-300 hover:bg-yellow-500 px-4 text-gray-900">Pesquisar modelo</button>
                </Link>
            </div>
            
        </div>
    )
}