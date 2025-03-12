package com.guidev1911.agendamento_notificacao_api.controller;

import com.guidev1911.agendamento_notificacao_api.business.AgendamentoService;
import com.guidev1911.agendamento_notificacao_api.business.mapper.IAgendamentoMapper;
import com.guidev1911.agendamento_notificacao_api.dto.in.AgendamentoRecord;
import com.guidev1911.agendamento_notificacao_api.dto.out.AgendamentoRecordOut;
import com.guidev1911.agendamento_notificacao_api.infrastructure.entities.Agendamento;
import com.guidev1911.agendamento_notificacao_api.infrastructure.enums.StatusNotificacaoEnum;
import com.guidev1911.agendamento_notificacao_api.infrastructure.repository.AgendamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgendamentoServiceTest {

    @Mock
    private AgendamentoRepository repository;

    @Mock
    private IAgendamentoMapper agendamentoMapper;

    @InjectMocks
    private AgendamentoService agendamentoService;

    private AgendamentoRecord agendamentoRecord;
    private AgendamentoRecordOut agendamentoRecordOut;
    private Agendamento agendamentoEntity;

    @BeforeEach
    void setUp() {
        agendamentoRecord = new AgendamentoRecord(
                "email@email.com",
                "55887996578",
                "Favor retornar a loja com urgência",
                LocalDateTime.of(2025, 1, 2, 11, 1, 1)
        );

        agendamentoEntity = Agendamento.builder()
                .id(1L)
                .dataHoraEnvio( LocalDateTime.of(2025, 1, 2, 11, 1, 1))
                .emailDestinatario("email@email.com")
                .telefoneDestinatario("55887996578")
                .mensagem("Favor retornar a loja com urgência")
                .dataHoraAgendamento(LocalDateTime.now())
                .build();

        agendamentoRecordOut = new AgendamentoRecordOut(
                1L,
                "email@email.com",
                "55887996578",
                "Favor retornar a loja com urgência",
                LocalDateTime.of(2025, 1, 2, 11, 1, 1),
                StatusNotificacaoEnum.AGENDADO
        );
    }

    @Test
    void deveGravarAgendamento() {
        when(agendamentoMapper.paraEntity(agendamentoRecord)).thenReturn(agendamentoEntity);
        when(repository.save(agendamentoEntity)).thenReturn(agendamentoEntity);
        when(agendamentoMapper.paraOut(agendamentoEntity)).thenReturn(agendamentoRecordOut);

        AgendamentoRecordOut resultado = agendamentoService.gravarAgendamento(agendamentoRecord);

        assertEquals(agendamentoRecordOut, resultado, "O objeto retornado deve ser igual ao esperado");
    }
}