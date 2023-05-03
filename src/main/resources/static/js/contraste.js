const modal = document.querySelector('.modal-container')
const tbody = document.querySelector('tbody')
const sId = document.querySelector('#m-id')
const sNome = document.querySelector('#m-nome')
const sEmail = document.querySelector('#m-email')
const sCelular = document.querySelector('#m-celular')
const btnSalvar = document.querySelector('#btnSalvar')

let itens
let id

function openModal(edit = false, index = 0) {
  modal.classList.add('active')

  modal.onclick = e => {
    if (e.target.className.indexOf('modal-container') !== -1) {
      modal.classList.remove('active')
    }
  }

  if (edit) {
    sId.value = itens[index].id
    sNome.value = itens[index].nome
    sEmail.value = itens[index].email
    sCelular.value = itens[index].celular
    id = index
  } else {
    sId.value = ''
    sNome.value = ''
    sEmail.value = ''
    sCelular.value = ''
  }
  
}

function editItem(index) {

  openModal(true, index)
}

function deleteItem(index) {
  itens.splice(index, 1)
  setItensBD()
  loadItens()
}

function insertItem(item, index) {
  let tr = document.createElement('tr')

  tr.innerHTML = `
    <td>${item.id}</td>
    <td>${item.nome}</td>
    <td>${item.email}</td>
    <td>${item.celular}</td>
    <td class="acao">
      <button onclick="editItem(${index})"><i class='bx bx-edit'></i></button>
    </td>
    <td class="acao">
      <button onclick="deleteItem(${index})"><i class='bx bx-trash'></i></button>
    </td>
  `
  tbody.appendChild(tr)
}

btnSalvar.onclick = e => {
  
  if (sId.value == '' || sNome.value == '' || sEmail.value == '' || sCelular.value == '') {
    return
  }

  e.preventDefault();

  if (id !== undefined) {
    itens[id].id = sId.value
    itens[id].nome = sNome.value
    itens[id].email = sEmail.value
    itens[id].celular = sCelular.value
  } else {
    itens.push({'id': sId.value,'nome': sNome.value, 'email': sEmail.value, 'celular': sCelular.value})
  }

  setItensBD()

  modal.classList.remove('active')
  loadItens()
  id = undefined
}

function loadItens() {
  itens = getItensBD()
  tbody.innerHTML = ''
  itens.forEach((item, index) => {
    insertItem(item, index)
  })

}

const getItensBD = () => JSON.parse(localStorage.getItem('dbfunc')) ?? []
const setItensBD = () => localStorage.setItem('dbfunc', JSON.stringify(itens))

loadItens()