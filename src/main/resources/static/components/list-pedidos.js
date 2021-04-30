class ListComprasComponent extends HTMLElement {
    constructor(){
        super();
        let id = this.getAttribute('pedido-id');
        let cliente= this.getAttribute('pedido-cliente');
        let servico= this.getAttribute('pedido-servico');

        this.innerHTML = `
                            <h2 class="accordion-header" id="heading${id}">
                              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target=#pedido${id} aria-expanded="false" aria-controls="pedido${id}">
                                  <span>${id}</span>
                              </button>
                            </h2>
                            <div id="pedido${id}" class="accordion-collapse collapse" aria-labelledby="heading${id}" data-bs-parent="#clientes">
                              <div class="accordion-body">
                                  <div class="row justify-content-between">
                                      <div class="col">
                                          <p><strong>Cliente:</strong>  <span>${cliente}</span></p>
                                          <p><strong>Servico:</strong>  <span> ${servico}</span></p>

                                      </div>
                                  </div>
                                  <br />
                              </div>
                            </div>
                        `
    }
}
window.customElements.define('list-pedidos-component', ListComprasComponent);