
// TODO: IMPLEMENTAR COMPONENTE
export default function LinhaPesquisaCarroModelo() {
    return (
        <div className="flex gap-4 justify-between">
            <label htmlFor="modelo">Modelo</label>
            <input type="text" id="modelo" name="modelo" className="p-3 rounded" />
        </div>
    )
}