package com.guidev1911.agendamento_notificacao_api.business.mapper;

import com.guidev1911.agendamento_notificacao_api.controller.dto.in.AgendamentoRecord;
import com.guidev1911.agendamento_notificacao_api.controller.dto.out.AgendamentoRecordOut;
import com.guidev1911.agendamento_notificacao_api.infrastructure.entities.Agendamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IAgendamentoMapper {

    Agendamento paraEntity(AgendamentoRecord agendamento);

    AgendamentoRecordOut paraOut(Agendamento agendamento);

    @Mapping(target = "dataHoraModificacao", expression = "java(LocalDateTime.now())")
    @Mapping(target = "statusNotificacao", expression = "java(StatusNotificacaoEnum.CANCELADO)")
    Agendamento paraEntityCancelamento(Agendamento agendamento);
}