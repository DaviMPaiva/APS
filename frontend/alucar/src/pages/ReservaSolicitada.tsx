import Header from "../components/Header";

export default function ReservaSolicitada() {
    return (
        <>
            <div className="flex flex-col m-6 items-center">
                <Header/>
            </div>
            <div className="flex flex-col items-center">
                <p className="font-semibold text-2xl">Sua reserva foi solicitada com sucesso!</p>
                <p>Verifique seu email, caso não tenha recebido, tente novamente.</p>
            </div>
        </>
        
    )
}