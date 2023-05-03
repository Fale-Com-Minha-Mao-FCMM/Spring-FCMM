const modalA = document.querySelector('.modal-container2')
const tbody = document.querySelector('tbody')
const sIdA = document.querySelector('#m-idA')
const sNomeA = document.querySelector('#m-nomeA')
const sEmailA = document.querySelector('#m-emailA')
const sFuncao = document.querySelector('#m-funcao')
const btnSalvarA = document.querySelector('#btnSalvarA')

let itensA
let idA

function openModal2(edit = false, index = 0) {
  modalA.classList.add('active')

  modalA.onclick = e => {
    if (e.target.className.indexOf('modal-container2') !== -1) {
      modalA.classList.remove('active')
    }
  }

  if (edit) {
    sIdA.value = itens[index].idA
    sNomeA.value = itens[index].nomeA
    sEmailA.value = itens[index].emailA
    sFuncao.value = itens[index].funcao
    idA = index
  } else {
    sIdA.value = ''
    sNomeA.value = ''
    sEmailA.value = ''
    sFuncao.value = ''
  }
  
}

function editItem(index) {

  openModal2(true, index)
}

function deleteItem(index) {
  itens.splice(index, 1)
  setItensBD()
  loadItens()
}

function insertItem(item, index) {
  let tr = document.createElement('tr')

  tr.innerHTML = `
    <td>${item.idA}</td>
    <td>${item.nomeA}</td>
    <td>${item.emailA}</td>
    <td>${item.funcao}</td>
    <td class="acao">
      <button onclick="editItem(${index})"><i class='bx bx-edit'></i></button>
    </td>
    <td class="acao">
      <button onclick="deleteItem(${index})"><i class='bx bx-trash'></i></button>
    </td>
  `
  tbody.appendChild(tr)
}

btnSalvarA.onclick = e => {
  
  if (sIdA.value == '' || sNomeA.value == '' || sEmailA.value == '' || sFuncao.value == '') {
    return
  }

  e.preventDefault();

  if (idA !== undefined) {
    itens[idA].idA = sIdA.value
    itens[idA].nomeA = sNomeA.value
    itens[idA].emailA = sEmailA.value
    itens[idA].funcao = sFuncao.value
  } else {
    itens.push({'idA': sIdA.value,'nomeA': sNomeA.value, 'emailA': sEmailA.value, 'funcao': sFuncao.value})
  }

  setItensBD()

  modalA.classList.remove('active')
  loadItens()
  id = indefinido
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