import { Link } from "react-router-dom";

export default function Header() {
    return (
        <div className="flex flex-col items-center">
            <Link to={`/`}>
                <div className='flex justify-center font-sans text-[4rem] font-bold mb-5 hover:scale-[1.01] ease-in-out duration-300'>Alucar</div>
            </Link>
        </div>
    )
}