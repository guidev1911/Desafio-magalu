package com.guidev1911.agendamento_notificacao_api.controller;
import com.guidev1911.agendamento_notificacao_api.business.AgendamentoService;
import com.guidev1911.agendamento_notificacao_api.dto.in.AgendamentoRecord;
import com.guidev1911.agendamento_notificacao_api.dto.out.AgendamentoRecordOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public ResponseEntity<AgendamentoRecordOut> gravarAgendamentos(@RequestBody AgendamentoRecord agendamento){
        return ResponseEntity.ok(agendamentoService.gravarAgendamento(agendamento));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoRecordOut> buscarAgendamentoPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(agendamentoService.buscarAgendamentoPorId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable("Id") Long id){
        agendamentoService.cancelarAgendamento(id);
        return ResponseEntity.accepted().build();
    }
}
