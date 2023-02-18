package org.roronoa.banklyoperation.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.roronoa.banklyoperation.dto.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "banklyWallet")
public interface IWalletService {
    @GetMapping("/api/v1/wallet/{reference}")
    public ResponseDTO<Double> getSoldWallet(@PathVariable(name = "reference") String reference);
    @PutMapping(path = "/api/v1/wallet")
    public ResponseDTO<Boolean> update(@RequestParam @NotNull @NotEmpty String reference,@RequestParam @NotNull @NotEmpty Double sold);
}
