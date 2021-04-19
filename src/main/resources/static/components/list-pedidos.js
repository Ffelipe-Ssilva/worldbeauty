class ListComprasComponent extends HTMLElement {
    constructor(){
        super();
        let id = this.getAttribute('pedido-id');
        let descricao = this.getAttribute('pedido-descricao');
        let data = this.getAttribute('pedido-data');
        let preco = this.getAttribute('pedido-preco');
        let tipo = this.getAttribute('pedido-tipo');

        this.innerHTML = `
                            <h2 class="accordion-header" id="heading${id}">
                              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target=#compra${id} aria-expanded="false" aria-controls="compra${id}">
                                  <span>${data}</span>
                              </button>
                            </h2>
                            <div id="compra${id}" class="accordion-collapse collapse" aria-labelledby="heading${id}" data-bs-parent="#clientes">
                              <div class="accordion-body">
                                  <div class="row justify-content-between">
                                      <div class="col">
                                          <p><strong>Descrição:</strong>  <span>${descricao}</span></p>
                                          <p><strong>Data:</strong>  <span>${data}</span></p>
                                          <p><strong>Preço:</strong>  <span>R$ ${preco}</span></p>
                                          <p><strong>Tipo:</strong>  <span>${tipo}</span></p>

                                      </div>
                                  </div>
                                  <br />
                              </div>
                            </div>
                        `
    }
}
window.customElements.define('list-pedidos-component', ListComprasComponent);