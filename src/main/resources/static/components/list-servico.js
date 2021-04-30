class ListComponent extends HTMLElement {
    constructor(){
        super();
        let id =  this.getAttribute('servico-id');
        let nome =  this.getAttribute('servico-nome');
        let frequencia =  this.getAttribute('servico-frequencia');

        this.innerHTML = `
                            <h2 class="accordion-header" id="heading${id}">
                              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target=#servico${id} aria-expanded="false" aria-controls="user${id}">
                                  <span>${nome}</span>
                              </button>
                            </h2>
                            <div id="servico${id}" class="accordion-collapse collapse" aria-labelledby="heading${id}" data-bs-parent="#servicos">
                              <div class="accordion-body">
                                  <div class="row justify-content-between">
                                      <div class="col">
                                          <p><strong>Quantas vezes foi pedido:</strong>  <span>${frequencia}</span></p>
                                      </div>
                                      <div class="col text-end">

                                      </div>
                                  </div>
                                  <br />
                              </div>
                            </div>
                        `
    }
}
window.customElements.define('list-component', ListComponent);