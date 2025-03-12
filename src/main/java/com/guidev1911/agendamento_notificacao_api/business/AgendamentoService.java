package com.guidev1911.agendamento_notificacao_api.business;

import com.guidev1911.agendamento_notificacao_api.business.mapper.IAgendamentoMapper;
import com.guidev1911.agendamento_notificacao_api.dto.in.AgendamentoRecord;
import com.guidev1911.agendamento_notificacao_api.dto.out.AgendamentoRecordOut;
import com.guidev1911.agendamento_notificacao_api.infrastructure.Exception.NotFoundException;
import com.guidev1911.agendamento_notificacao_api.infrastructure.entities.Agendamento;
import com.guidev1911.agendamento_notificacao_api.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final IAgendamentoMapper agendamentoMapper;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecord agendamento){
         return agendamentoMapper
                 .paraOut(repository.save(agendamentoMapper.paraEntity(agendamento)));
    }
    public AgendamentoRecordOut buscarAgendamentoPorId(Long id){
        return agendamentoMapper.paraOut(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrado")));
    }
    public void cancelarAgendamento(Long id){
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrado"));

        repository.save(agendamentoMapper.paraEntityCancelamento(agendamento));
    }
}
