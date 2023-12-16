import { useState, useContext } from "react";
import { AlucarContext } from "../contexts/AlucarContext";
import axios from "axios";
import Historico from "./Historico";
import { Link } from "react-router-dom";

export default function Home() {

    return (
        <div className="flex flex-col items-center gap-4">
            <div className='flex justify-center font-sans text-2xl font-bold pt-4'>Alucar</div>
            <Link to={`/historico`}>
                <button className="rounded-full bg-red-300 hover:bg-red-500 px-4 text-gray-900">Ver histórico</button>
            </Link>
        </div>
    )
}