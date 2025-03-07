package com.guidev1911.agendamento_notificacao_api.business;

import com.guidev1911.agendamento_notificacao_api.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
}
