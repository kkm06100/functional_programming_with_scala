package io

import cats.effect.{IO, IOApp}

object MyApp extends IOApp.Simple {
  def run: IO[Unit] = IO.println("This is safe... kinda.")
}