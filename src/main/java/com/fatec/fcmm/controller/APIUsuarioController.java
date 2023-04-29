@RestController
class ValidateRequestBodyController {
 @PostMapping("/validateBody")
 ResponseEntity<String> validateBody(@Valid @RequestBody Input input) {
 return ResponseEntity.ok("valid");
 }
}
