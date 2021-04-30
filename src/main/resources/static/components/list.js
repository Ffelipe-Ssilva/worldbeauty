class ListComponent extends HTMLElement {
    constructor(){
        super();
        let id =  this.getAttribute('delete-id');
        let nome =  this.getAttribute('user-nome');
        let genero =  this.getAttribute('user-genero');
        let dataNascimento =  this.getAttribute('user-nascimento');
        let telefone =  this.getAttribute('user-telefone');
        console.log(telefone);

        this.innerHTML = `
                            <h2 class="accordion-header" id="heading${id}">
                              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target=#user${id} aria-expanded="false" aria-controls="user${id}">
                                  <span>${nome}</span>
                              </button>
                            </h2>
                            <div id="user${id}" class="accordion-collapse collapse" aria-labelledby="heading${id}" data-bs-parent="#clientes">
                              <div class="accordion-body">
                                  <div class="row justify-content-between">
                                      <div class="col">
                                          <p><strong>Gênero:</strong>  <span>${genero}</span></p>
                                          <p><strong>Data de nascimento:</strong>  <span>${dataNascimento}</span></p>
                                          <p><strong>Telefone:</strong>  <span>${telefone}</span></p>
                                      </div>
                                      <div class="col text-end">
                                          <trash-component delete-id="${id}"></trash-component><br /><br />
                                          <edit-component edit-id="${id}"></edit-component><br /> <br />
                                          <shop-component user-id="${id}"></shop-component>

                                      </div>
                                  </div>
                                  <br />
                              </div>
                            </div>
                        `
    }
}
window.customElements.define('list-component', ListComponent);