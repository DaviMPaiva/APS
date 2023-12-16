public class Reservas implements InterfaceReservas{

    private int id;
    private Date dataReserva;
    private Cliente cliente;
    private Carro carro;
    private float valorReserva;
    private boolean pago;
  
    public Reservas(int id, Date dataReserva, Cliente cliente, Carro carro, float valorReserva, boolean pago) {
      this.id = id;
      this.dataReserva = dataReserva;
      this.cliente = cliente;
      this.carro = carro;
      this.valorReserva = valorReserva;
      this.pago = pago;
    }
  
    public int getId() {
      return id;
    }
  
    public void setId(int id) {
      this.id = id;
    }
  
    public Date getDataReserva() {
      return dataReserva;
    }
  
    public void setDataReserva(Date dataReserva) {
      this.dataReserva = dataReserva;
    }
  
    public Cliente getCliente() {
      return cliente;
    }
  
    public void setCliente(Cliente cliente) {
      this.cliente = cliente;
    }
  
    public Carro getCarro() {
      return carro;
    }
  
    public void setCarro(Carro carro) {
      this.carro = carro;
    }
  
    public float getValorReserva() {
      return valorReserva;
    }
  
    public void setValorReserva(float valorReserva) {
      this.valorReserva = valorReserva;
    }
  
    public boolean isPago() {
      return pago;
    }
  
    public void setPago(boolean pago) {
      this.pago = pago;
    }
  
    public float calculaTaxasAtraso() {
      //TODO: Implementar lógica de cálculo de taxas de atraso
      return 0.0f;
    }
  
    public void registraPagamento() {
      //TODO: Implementar lógica para registrar pagamento da reserva
    }
  
    public void registraTaxas() {
      //TODO: Implementar lógica para registrar taxas da reserva
    }
  
    public List<Reserva> buscaHistorico() {
      //TODO: Implementar lógica para buscar histórico de reservas
      return null;
    }
  
    public Carro PesquisaCarrosDisponiveis(Date dataInicio, Date dataFim) {
      //TODO: Implementar lógica para pesquisar carros disponíveis
      return null;
    }
  
    public void criaNovaReserva(Cliente cliente, Carro carro, Date dataInicio, Date dataFim) {
      //TODO: Implementar lógica para criar uma nova reserva
    }
  }
  