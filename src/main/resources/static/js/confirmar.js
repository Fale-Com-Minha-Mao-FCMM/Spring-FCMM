function confirmarExclusao(event) {
  event.preventDefault();
  const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
      confirmButton: 'btn btn-success',
      cancelButton: 'btn btn-danger'
    },
    buttonsStyling: false
  })

  swalWithBootstrapButtons.fire({
    title: 'Você tem certeza que deseja excluir?',
    text: "Essa ação é irreversível",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Sim!',
    cancelButtonText: 'Não.',
    reverseButtons: true
  }).then((result) => {
    if (result.isConfirmed) {
      swalWithBootstrapButtons.fire(
        'Excluído!',
        'success'
      )
    } else if (
      /* Read more about handling dismissals below */
      result.dismiss === Swal.DismissReason.cancel
    ) {
      swalWithBootstrapButtons.fire(
        'Cancelado',
        'Sua operação foi cancelada.)',
        'error'
      )
    }
  })
}